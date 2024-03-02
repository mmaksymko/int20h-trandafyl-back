package dev.trandafyl.int20htrandafylback.services;

import dev.trandafyl.int20htrandafylback.dto.GroupResponse;
import dev.trandafyl.int20htrandafylback.mappers.GroupMapper;
import dev.trandafyl.int20htrandafylback.models.Group;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import dev.trandafyl.int20htrandafylback.repositories.GroupRepository;

import java.util.List;
import java.util.Set;


@Service
@AllArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    public List<String> getAllGroups(){
        return groupRepository.findAllNames();
    }

    public List<Group> getByGroupNames(Set<String> groupNames){
        return groupRepository.findByGroupNames(groupNames);
    }

    public GroupResponse getByGroupName(String groupName) {
        var name = groupMapper.toGroupName(groupName);
        return this.getBySpecialityAndYearAndNumber(name.speciality(), name.year(), name.number());
    }

    public GroupResponse getBySpecialityAndYearAndNumber(String speciality, int year, int number) {
        return groupMapper.toResponse(groupRepository.findBySpecialityAndYearAndNumber(speciality, year, number));
    }

}
