class Solution {
    LinkedList<List<Integer>> list = new LinkedList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return list;
        }
        List<Integer> level = new ArrayList<>();
        list.add(level);
        level.add(root.val);

        solve(root, 1);

        reverse();

        return list;
    }

    public void reverse() {
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                continue;
            }
            List<Integer> level = list.get(i);

            List<Integer> change = new ArrayList<>();
            for (int j = level.size() - 1; j >= 0; j--) {
                change.add(level.get(j));
            }
            list.set(i, change);
                    
        }
    }

    public void solve(TreeNode node, int level) {
        if (node.left == null && node.right == null) {
            return;
        }

        List<Integer> newLevel;
        if (level < list.size()) {
            newLevel = list.get(level);
        } else {
            newLevel = null;
        }
        if (newLevel == null) {
            newLevel = new ArrayList<>();
            list.add(newLevel);
        }

        if (node.left != null) {
            newLevel.add(node.left.val);
            solve(node.left, level + 1);
        }

        if (node.right != null) {
            newLevel.add(node.right.val);
            solve(node.right, level + 1);
        }
    }
}
