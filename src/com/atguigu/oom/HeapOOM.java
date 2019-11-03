package com.atguigu.oom;

import java.util.ArrayList;
import java.util.List;
/**
 * -Xms20M -Xmx20M -Xmn10M -XX:+HeapDumpOnOutOfMemoryError
 * @author DETBG23
 *
 */
public class HeapOOM {

	static class OOMObject{
		
	}
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<HeapOOM.OOMObject>();
		while (true) {
			list.add(new OOMObject());
		}
	}
}
