package cn.gaily.bill.singlebilltree;

import javax.swing.tree.DefaultMutableTreeNode;
import nc.ui.ml.NCLangRes;
import nc.vo.bd.meta.BDObjectTreeCreateStrategy;

public class ListTreeCreateStrategy extends BDObjectTreeCreateStrategy {

	@Override
	public DefaultMutableTreeNode getRootNode() {
		return new DefaultMutableTreeNode("Ê÷");
	}

}