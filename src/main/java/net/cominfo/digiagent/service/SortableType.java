package net.cominfo.digiagent.service;


/**
 * Sortable类型标志位枚举
 * @author Administrator
 *
 */
public enum SortableType {
	
	Category("C") {
		@Override
		public SortableType parent() {
			return null;
		}
	},
	
	Product("P") {
		@Override
		public SortableType parent() {
			return Category;
		}
	},
	
	Brand("B") {
		@Override
		public SortableType parent() {
			return Product;
		}
	},
	
	Supplier("S") {
		@Override
		public SortableType parent() {
			return Brand;
		}
	};

	private String flag;

	public String getFlag() {
		return flag;
	}

	private SortableType(String flag) {
		this.flag = flag;
	}

	// 找到上级标志位
	public abstract SortableType parent();
	
}
