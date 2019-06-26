package com.vvhien.paging;

public interface Pageble { //2506
	Integer getPage();
	Integer getOffset();
	Integer getLimit();
	Sorter getSorter();
}
