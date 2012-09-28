package org.tasclin1.mopet1.service;

import org.tasclin1.mopet1.domain.Tree;

public class DoseModCreator extends DbNodeCreator {
	public Tree addChild() {
		Tree t = super.addChild();
//		SchemaMtl schemaMtl = (SchemaMtl)treeManager;
		return t;
	}
}
