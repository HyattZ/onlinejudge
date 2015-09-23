package com.onlinejudge.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Entity;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.onlinejudge.domain.SubmitPageProblemInfo;
import com.onlinejudge.domain.database.Problem;
import com.onlinejudge.dto.ResultFormBean;

/**
 * @author ��Ц��
 *
 * @time 2015��9��15��
 * 
 */
public interface ProblemDao {
	public abstract List<Problem> getProblemList(int length,int beginIndex);

	public abstract String getFlagById(int problemid);

	public abstract long getProblemCount();

	public abstract SubmitPageProblemInfo getSFPProblem(int id);
}
