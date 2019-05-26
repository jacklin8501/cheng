/**
 * 
 */
package com.cheng.core.utils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

/**
 * @author jack.lin
 *
 */
public final class EmptyUtils {

	public static boolean isEmpty(Object obj) {
		if (null == obj) 
			return true;
		
		if (String.class == obj.getClass())
			return obj.toString().trim().length() - 0 == 0;
		if (List.class.isInstance(obj))
			return ((List<?>) obj).isEmpty();
		if (Set.class.isInstance(obj))
			return ((Set<?>) obj).isEmpty();
		if (Iterator.class.isInstance(obj)) 
			return !((Iterator<?>) obj).hasNext();
		if (Map.class.isInstance(obj)) 
			return ((Map<?, ?>) obj).isEmpty();
		if (obj.getClass().isArray())
			return Array.getLength(obj) - 0 == 0;
		if (Collection.class.isInstance(obj))
			return ((Collection<?>) obj).size() == 0;
		return false;
	}
	
	public static boolean isNotEmpty(Object obj) {
		return !EmptyUtils.isEmpty(obj);
	}
	
	@SuppressWarnings("unchecked")
	public static <T, U> void clearPropertyValue(Object obj, BiConsumer<T, U> consumer) {
		consumer.accept((T) obj, null);
	}
}
