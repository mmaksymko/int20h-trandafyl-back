package dev.trandafyl.int20htrandafylback.mappers;

import dev.trandafyl.int20htrandafylback.dto.GroupName;
import dev.trandafyl.int20htrandafylback.dto.GroupResponse;
import dev.trandafyl.int20htrandafylback.models.Group;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class GroupMapper {
    private final CourseMapper courseMapper;

    public GroupResponse toResponse(Group group) {
        return
                GroupResponse.builder()
                .id(group.getId())
                .name(group.getName())
                .courses(group.getCourses().stream().map(courseMapper::toResponse).collect(Collectors.toSet()))
                .build();
    }

    public Group toEntity(GroupResponse groupResponse) {
        return Group.builder()
                .id(groupResponse.getId())
                .number(groupResponse.getNumber())
                .speciality(groupResponse.getSpeciality())
                .year(groupResponse.getYear())
                .courses(groupResponse.getCourses().stream().map(courseMapper::toEntity).collect(Collectors.toSet()))
                .build();
    }

    public GroupName toGroupName(String groupName) {
        var split = groupName.split("-");
        var speciality = split[0];
        var year = Integer.parseInt(split[1].substring(0,1));
//        System.out.println(speciality);
        var number = Integer.parseInt(split[1].substring(1));
        return new GroupName(speciality, year, number);
    }

    public GroupName toGroupName(String speciality, int year, int number) {
        return new GroupName(speciality, year, number);
    }

    public String nameToString(GroupName groupName) {
        return groupName.speciality() + "-" + groupName.year() + "" + groupName.number();
    }
}
