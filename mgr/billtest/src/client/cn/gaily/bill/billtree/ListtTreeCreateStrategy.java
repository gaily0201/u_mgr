package cn.gaily.bill.billtree;

import javax.swing.tree.DefaultMutableTreeNode;

import nc.desktop.ui.WorkbenchEnvironment;
import nc.ui.ml.NCLangRes;
import nc.vo.bd.meta.BDObjectTreeCreateStrategy;
import nc.vo.org.util.OrgPubUtil;

/**
 * 
 * 树构造策略
 *
 */
public class ListtTreeCreateStrategy extends BDObjectTreeCreateStrategy {

	private DefaultMutableTreeNode root = new DefaultMutableTreeNode("根");
	
	@Override
	public DefaultMutableTreeNode getRootNode() {
			return root;
	}
}
