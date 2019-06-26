package com.vvhien.paging;

public class PageRequest implements Pageble {//2506
	Integer page;
	Integer maxPageItem;
	private Sorter sorter;
	
	public PageRequest(Integer page, Integer maxPageItem, Sorter sorter) {
		this.page = page;
		this.maxPageItem = maxPageItem;
		this.sorter = sorter;
	}

	@Override
	public Integer getPage() {
		return page;
	}

	@Override
	public Integer getOffset() {
		if(page!= null && maxPageItem != null) {
			return (page - 1) * maxPageItem;
		}
		return null;
	}

	@Override
	public Integer getLimit() {
		return maxPageItem;
	}

	@Override
	public Sorter getSorter() {
		return sorter;
	}

}
