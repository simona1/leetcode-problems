
/**
 * LeetCode problem # 1472, 'Design Browser History'
 * https://leetcode.com/problems/design-browser-history
 */

import java.util.*;

class BrowserHistory {
    private Stack<String> bwd;
    private Stack<String> fwd;
    private String curr;

    public BrowserHistory(String homepage) {
        this.bwd = new Stack<>();
        this.fwd = new Stack<>();
        this.curr = homepage;
    }

    public void visit(String url) {
        this.bwd.push(this.curr);
        this.curr = url;
        this.fwd = new Stack<>();
    }

    public String back(int steps) {
        while (steps-- > 0 && !this.bwd.isEmpty()) {
            this.fwd.push(this.curr);
            this.curr = this.bwd.pop();
        }
        return this.curr;
    }

    public String forward(int steps) {
        while (steps-- > 0 && !this.fwd.isEmpty()) {
            this.bwd.push(this.curr);
            this.curr = this.fwd.pop();
        }
        return this.curr;
    }
}
