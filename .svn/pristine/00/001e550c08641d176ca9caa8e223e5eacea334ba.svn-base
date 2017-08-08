package tst.project.page;

import java.util.ArrayList;
import java.util.List;

public class PageUtils {
	private static int pageSize = 10;

	public static List<Object> getPage(List<Object> objects, int page) {
		if (objects != null) {
			List<Object> objectList = new ArrayList<Object>();
			for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
				if (i < objects.size()) {
					objectList.add(objects.get(i));
				} else {
					break;
				}
			}

			return objectList;
		}
		return objects;
	}
}
