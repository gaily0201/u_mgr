package cn.gaily.bill.billtree;

import javax.swing.tree.DefaultMutableTreeNode;

import nc.desktop.ui.WorkbenchEnvironment;
import nc.ui.ml.NCLangRes;
import nc.vo.bd.meta.BDObjectTreeCreateStrategy;
import nc.vo.org.util.OrgPubUtil;

/**
 * 
 * ���������
 *
 */
public class ListtTreeCreateStrategy extends BDObjectTreeCreateStrategy {

	private DefaultMutableTreeNode root = new DefaultMutableTreeNode("��");
	
	@Override
	public DefaultMutableTreeNode getRootNode() {
			return root;
	}
}
