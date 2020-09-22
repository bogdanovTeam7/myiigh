package hu.ak_akademia.myiigh.db.dao;

import java.util.List;

public interface ReturnerDataBaseDao<R> {

	List<R> retrieve();

}
