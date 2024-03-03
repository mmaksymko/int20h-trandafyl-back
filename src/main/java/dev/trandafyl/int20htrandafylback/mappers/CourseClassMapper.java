package dev.trandafyl.int20htrandafylback.mappers;

import dev.trandafyl.int20htrandafylback.dto.ScheduleStudentItemResponse;
import dev.trandafyl.int20htrandafylback.dto.ScheduleTeacherItemResponse;
import dev.trandafyl.int20htrandafylback.models.CourseClass;
import dev.trandafyl.int20htrandafylback.models.Group;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CourseClassMapper {
    public ScheduleStudentItemResponse mapToScheduleStudentItemResponse(CourseClass courseClass){
        return
                ScheduleStudentItemResponse.builder()
                        .courseName(courseClass.getCourse().getName())
                        .classType(courseClass.getClassType().name())
                        .teacherName(courseClass.getTeacher().getName())
                        .office(courseClass.getOffice())
                        .startTime(courseClass.getClassHours().getStartTime())
                        .endTime(courseClass.getClassHours().getEndTime())
                        .classNumber(courseClass.getClassHours().getNumber())
                        .weekDay(courseClass.getWeekDay().name())
                        .weekType(courseClass.getWeekType().name())
                        .build();
    }


    public ScheduleTeacherItemResponse mapToScheduleTeacherItemResponse(CourseClass courseClass){
        return
                ScheduleTeacherItemResponse.builder()
                        .courseName(courseClass.getCourse().getName())
                        .classType(courseClass.getClassType().name())
                        .groups(courseClass.getGroups().stream().map(Group::getName).collect(Collectors.toList()))
                        .office(courseClass.getOffice())
                        .startTime(courseClass.getClassHours().getStartTime())
                        .endTime(courseClass.getClassHours().getEndTime())
                        .classNumber(courseClass.getClassHours().getNumber())
                        .weekDay(courseClass.getWeekDay().name())
                        .weekType(courseClass.getWeekType().name())
                        .build();
    }

}
