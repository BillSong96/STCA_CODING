class Solution {
    public int calculate(String s) { 
        try {
            return (int) myCalculator(s);
        } catch(Exception e) {
            return 0;
        }
    }
    // implement bad expression check, double, negative and the support of '*' and '/'
    public static double myCalculator(String expression) throws Exception {
        // parentheses
        int[] firstParenthesesPos = findFirstParentheses(expression);
        if (firstParenthesesPos != null) {
            String left = firstParenthesesPos[0] == 0 ? "" : expression.substring(0, firstParenthesesPos[0]);
            String right = firstParenthesesPos[1] == expression.length() - 1 ? "" : expression.substring(firstParenthesesPos[1] + 1, expression.length());
            try {
                String mid = Double.toString(myCalculator(expression.substring(firstParenthesesPos[0] + 1, firstParenthesesPos[1])));
                return myCalculator(left + mid + right);
            } catch (Exception e) {
                throw e;
            }
        }
        
        // indexes of operators
        List<Integer> operatorPos = new ArrayList<>();
        for (int i = 1; i < expression.length() - 1; i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (operatorPos.isEmpty() || operatorPos.get(operatorPos.size() - 1) != i - 1) operatorPos.add(i);
            }
        }
        if (operatorPos.isEmpty()) {
            try {
                return Double.parseDouble(expression);
            } catch (Exception e) {
                throw badExpressionException(e.getMessage());
            }
        }

        List<Object> objectsList = new ArrayList<>();
        for (int i = 0; i < operatorPos.size(); i++) {
            int operatorIndex = operatorPos.get(i);
            try {
                objectsList.add(Double.parseDouble(expression.substring(i == 0 ? 0 : operatorPos.get(i - 1) + 1, operatorIndex)));
            } catch (Exception e) {
                throw badExpressionException(e.getMessage());
            }
            objectsList.add(expression.charAt(operatorIndex));
            if (i == operatorPos.size() - 1) {
                try {
                    objectsList.add(Double.parseDouble(expression.substring(operatorIndex + 1, expression.length())));
                } catch (Exception e) {
                    throw badExpressionException(e.getMessage());
                }
            }
        }

        // calculate '*' and '/'
        Stack<Object> st = new Stack<>();
        for (Object obj : objectsList) {
            if (st.empty() || obj instanceof Character || (char) st.peek() == '+' || (char) st.peek() == '-') st.push(obj);
            else {
                double numOfObj = (double) obj;
                char operator = (char) st.pop();
                double numOfPre = (double) st.pop();
                if (operator == '*') st.push(numOfPre * numOfObj);
                else st.push(numOfPre / numOfObj);
            }
        }

        // calculate '+' and '-'
        double ret = 0.0;
        while (st.size() > 1) {
            double numOfObj = (double) st.pop();
            char operator = (char) st.pop();
            if (operator == '+') ret += numOfObj;
            else ret -= numOfObj;
        }
        return ret + (double) st.pop();
    }

    private static int[] findFirstParentheses(String expression) {
        int lPPos = -1, lPCount = 0, rPCount = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                if (lPPos == -1) lPPos = i;
                lPCount++;
            }
            if (expression.charAt(i) == ')') {
                rPCount++;
                if (lPCount == rPCount) return new int[]{lPPos, i};
            }
        }
        return null;
    }

    private static Exception badExpressionException(String msg) {
        return new Exception(String.format("bad expression: %s", msg));
    }
}