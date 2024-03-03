package dev.trandafyl.int20htrandafylback.services;

import dev.trandafyl.int20htrandafylback.dto.AttendanceResponse;
import dev.trandafyl.int20htrandafylback.models.Attendance;
import dev.trandafyl.int20htrandafylback.repositories.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;

    public List<AttendanceResponse> getAllAttendances(Long studentId, LocalDate startDate, LocalDate endDate) {
        List<Attendance> attendanceRecords = attendanceRepository.findByStudentIdAndDateBetween(studentId, startDate, endDate);
        Map<LocalDate, AttendanceDayInfo> attendanceMap = new HashMap<>();

        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            final LocalDate dateForLambda = currentDate;
            int weekNumber = getWeekNumber(currentDate);
            DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
            boolean isOddWeek = weekNumber % 2 != 0;

            attendanceRecords.stream()
                    .filter(record -> record.getDate().equals(dateForLambda))
                    .forEach(record -> {
                        attendanceMap.computeIfAbsent(dateForLambda, k ->
                                new AttendanceDayInfo()).incrementAttendedClasses();
                    });

            currentDate = currentDate.plusDays(1);
        }
        return attendanceMap.entrySet().stream().map(entry -> new AttendanceResponse(
                entry.getKey().toString(),
                entry.getValue().getAttendedClasses(),
                entry.getValue().getTotalClasses(),
                calculatePercentage(entry.getValue().getAttendedClasses(), entry.getValue().getTotalClasses())
        )).collect(Collectors.toList());
    }

    private double calculatePercentage(int attended, int total) {
        return total > 0 ? (double) attended / total * 100 : 0;
    }

    private int getWeekNumber(LocalDate date) {
        long daysBetween = daysBetween(LocalDate.of(date.getYear(), 1, 1), date);
        return (int) (daysBetween / 7) + 1;
    }

    private long daysBetween(LocalDate start, LocalDate end) {
        long days = 0;
        LocalDate tempDate = LocalDate.from(start);
        while (tempDate.isBefore(end) || tempDate.isEqual(end)) {
            days++;
            tempDate = tempDate.plusDays(1);
        }
        return days;
    }

    private static class AttendanceDayInfo {
        private int attendedClasses = 0;
        private int totalClasses = 0;

        public void incrementAttendedClasses() {
            attendedClasses++;
        }

        public void incrementTotalClasses(int classes) {
            totalClasses += classes;
        }

        public int getAttendedClasses() {
            return attendedClasses;
        }

        public int getTotalClasses() {
            return totalClasses;
        }
    }
}
