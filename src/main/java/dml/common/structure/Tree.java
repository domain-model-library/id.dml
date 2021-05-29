package dml.common.structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Tree<E extends TreeNode> {
	public void build(List<E> nodes, E root,
			Map<Object, List<Object>> nodeIdchildrenIds) {
		Map<Object, E> nodesMap = new HashMap<>();
		for (E node : nodes) {
			nodesMap.put(node.getId(), node);
		}
		for (Entry<Object, List<Object>> entry : nodeIdchildrenIds.entrySet()) {
			E node = nodesMap.get(entry.getKey());
			if (node == null) {
				continue;
			}
			List<Object> childrenIds = entry.getValue();
			if (childrenIds == null || childrenIds.isEmpty()) {
				continue;
			}
			List<E> children = new ArrayList<>();
			for (Object childId : childrenIds) {
				E child = nodesMap.get(childId);
				if (child == null) {
					continue;
				}
				child.setSuperior(node);
				children.add(child);
			}
			node.setChildren((List) children);
		}
	}
}
