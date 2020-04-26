class Solution {
    private List<Integer> retList = new ArrayList<>();
        
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int target = (int) Math.pow(2.0, req_skills.length) - 1;
        Map<String, Integer> skillMap = buildMap(req_skills);
        int N = people.size();
        List<Integer> peoples = new ArrayList<>();
        for (List<String> peopleSkill : people) {
            peoples.add(peopleToInt(peopleSkill, skillMap));
        }
        fun(peoples);
        dfs(0, N, 0, target, peoples, new ArrayList<>());
        int retLen = retList.size();
        int[] ret = new int[retLen];
        for (int i = 0; i < retLen; i++) {
            ret[i] = retList.get(i);
        }
        return ret;
    }
    
    private Map<String, Integer> buildMap(String[] skills) {
        Map<String, Integer> skillMap = new HashMap<>();
        int n = 1;
        for (String skill : skills) {
            skillMap.put(skill, n);
            n *= 2;
        }
        return skillMap;
    }
    
    private int peopleToInt(List<String> people, Map<String, Integer> skillMap) {
        int ret = 0;
        for (String skill : people) {
            ret += skillMap.get(skill);
        }
        return ret;
    }
    
    private void dfs(int i, int N, int num, int target, List<Integer> peoples, List<Integer> list) {
        if (num == target) {
            if (retList.size() == 0 || list.size() < retList.size()) {
                retList = new ArrayList<>();
                retList.addAll(list);
            }
            return;
        }
        if (i == N) return;
        dfs(i + 1, N, num, target, peoples, list);
        int newNum = num | peoples.get(i);
        if (newNum != num) {
            list.add(i);
            dfs(i + 1, N, newNum, target, peoples, list);
            list.remove(list.size() - 1);
        }
    }
    
    private void fun(List<Integer> peoples) {
        int len = peoples.size();
        for (int i = 0; i < len; i++) {
            boolean flag = true;
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                if ((peoples.get(i) | peoples.get(j)) == peoples.get(j)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                peoples.set(i, 0);
            }
        }
    }
}