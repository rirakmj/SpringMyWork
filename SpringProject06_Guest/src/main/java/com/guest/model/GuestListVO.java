package com.guest.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GuestListVO {
	private List<GuestVO> arr;
	private int count;
//	public GuestListVO(List<GuestVO> arr, int count) {
//		this.arr = arr;
//		this.count = count;
	}
//	public List<GuestVO> getArr() {
//		return arr;
//	}
//	public int getCount() {
//		return count;
//}
