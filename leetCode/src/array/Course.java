package array;

import java.util.*;

public class Course {
    public static void main(String[] args) {
        Course m = new Course();

        Map<String, List<String>> coursesRelations = new HashMap<>();
        List<String> As = new ArrayList<>();
        As.add("B");
        As.add("C");
        List<String> Es = new ArrayList<>();
        Es.add("D");
        List<String> Fs = new ArrayList<>();
        Fs.add("A");
        Fs.add("E");
        coursesRelations.put("A", As);
        coursesRelations.put("E", Es);
        coursesRelations.put("F", Fs);

        Map<String, List<String>> coursesRelations2 = new HashMap<>();
        coursesRelations2.put("EE", null);

        List<String> ans = m.getCourses(coursesRelations);
        List<String> ans1 = m.getCourses(coursesRelations2);
        System.out.println(ans);
        System.out.println(ans1);
    }

    // List<String, List<String>> 前面的课 需要后面的课上完
    private List<String> getCourses(Map<String, List<String>> coursesRelations) {
        List<String> ans = new ArrayList<>();

        // 统计课程的前置课程数
        Map<String, Integer> statis = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : coursesRelations.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                statis.put(key, value.size());
            }
        }

        // 没有前置课程的课程为起点
        // 使用一个set 过滤出没有前置课 的课, 并将他们选为初始节点
        Set<String> allCourses = new HashSet<>();
        // 需要将 前面的课 需要后面的课上完，转换为上完前面的课，才能上后面的课。方便后续搜索。
        Map<String, List<String>> reverseCourseR = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : coursesRelations.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            allCourses.add(key);
            if (value != null) {
                for (String course : value) {
                    allCourses.add(course);
                    List<String> afterCourses = reverseCourseR.getOrDefault(course, new ArrayList<>());
                    afterCourses.add(key);
                    reverseCourseR.put(course, afterCourses);
                }
            }
        }

        Queue<String> courseQueue = new ArrayDeque<>();
        for (String singleCource : allCourses) {
            if (statis.get(singleCource) == null) {
                statis.put(singleCource, 0);
                courseQueue.add(singleCource);
            }
        }

        // BFS 同时输出结果到ans
        while (!courseQueue.isEmpty()) {
            String preCourse = courseQueue.poll();
            ans.add(preCourse);
            if (reverseCourseR.get(preCourse) != null) {
                for (String curCourse : reverseCourseR.get(preCourse)) {
                    int x = statis.get(curCourse) - 1;
                    statis.put(curCourse, x);
                    if (x == 0) {
                        courseQueue.add(curCourse);
                    }
                }
            }
        }
        return ans;
    }
}