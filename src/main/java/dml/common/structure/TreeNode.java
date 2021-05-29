package dml.common.structure;

import java.util.List;

public interface TreeNode {
	Object getId();

	void setId(Object id);

	TreeNode getSuperior();

	void setSuperior(TreeNode superior);

	List<TreeNode> getChildren();

	void setChildren(List<TreeNode> children);
}
