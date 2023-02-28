package kim.fzp.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Definition for a binary tree node.
 * author fzp
 * date 2023/2/28 17:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode {
    int val;

    TreeNode left;

    TreeNode right;

}
