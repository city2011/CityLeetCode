package array;

import java.util.*;

public class Main {
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 找寻基准数据的正确索引
            int index = getIndex(arr, low, high);

            // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            //quickSort(arr, 0, index - 1); 之前的版本，这种姿势有很大的性能问题，谢谢大家的建议
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }

    }

    private static int getIndex(int[] arr, int low, int high) {
        // 基准数据
        int tmp = arr[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];

        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmp;
        return low; // 返回tmp的正确位置
    }


    private List<String> getCourses(Map<String ,List<String>> coursesRelations){
        Set<String> allCourses = new HashSet<>();
        for(Map.Entry<String, List<String>> entry : coursesRelations.entrySet()){
            String key = entry.getKey();
            List<String> value = entry.getValue();
            allCourses.add(key);
            for(String course : value){
                allCourses.add(course);
            }
        }

        List<String> ans = new ArrayList<>();
        // 统计课程的前置课程数
        Map<String, Integer> statis = new HashMap<>();
        for(Map.Entry<String, List<String>> entry : coursesRelations.entrySet()){
            String key = entry.getKey();
            List<String> value = entry.getValue();
            statis.put(key, value.size());
        }

        for(String singleCource :allCourses){
            if(statis.get(singleCource) == null){
                statis.put(singleCource, 0);
            }
        }

        Queue<String> courseQueue = new ArrayDeque<>();
        // 没有前置课程的课程为起点
        for(Map.Entry<String, Integer> entry : statis.entrySet()){
            if(entry.getValue() == 0){
                courseQueue.add(entry.getKey());
            }
        }

        // BFS 同时输出结果到ans
        while(!courseQueue.isEmpty()){
            String preCourse = courseQueue.poll();
            ans.add(preCourse);
            for(String curCourse : coursesRelations.get(preCourse)){
                courseQueue.add(curCourse);
            }
        }
        return ans;
    }
}
