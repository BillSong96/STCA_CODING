/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    
    private List<Integer> list;
    
    private int N, i;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        for (NestedInteger element : nestedList) {
            append(element);
        }
        N = list.size();
        i = 0;
    }
    
    private void append(NestedInteger element) {
        if (element.isInteger()) list.add(element.getInteger());
        else for (NestedInteger subElement : element.getList()) {
            append(subElement);
        }
    }

    @Override
    public Integer next() {
        return i < N ? list.get(i++) : null;
    }

    @Override
    public boolean hasNext() {
        return i < N;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */