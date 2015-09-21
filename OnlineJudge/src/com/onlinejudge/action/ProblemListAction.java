package com.onlinejudge.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.util.ServletContextAware;

import com.onlinejudge.constant.Status;
import com.onlinejudge.domain.Notice;
import com.onlinejudge.domain.Problem;
import com.onlinejudge.service.NoticeService;
import com.onlinejudge.service.ProblemService;

/**
 * @author 赵笑天
 *
 * @time 2015年9月16日
 * 
 */
public class ProblemListAction implements RequestAware,ServletContextAware {
	private ProblemService problemService;
	private Map<String, Object> request;
	private int problemPage;
	private ServletContext context;


	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}
	
	public ProblemService getProblemService() {
		return problemService;
	}

	@Resource(name = "problemServiceImpl")
	public void setProblemService(ProblemService problemService) {
		this.problemService = problemService;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public int getProblemPage() {
		if (problemPage <= 0) {
			problemPage = 1;
		}

		return problemPage;
	}

	public void setProblemPage(int problemPage) {

		this.problemPage = problemPage;
	}

	public String getMainPage() {
		System.out.println(context.getRealPath(""));
		long problemCount = problemService.getProblemCount();
		// 获取可以得到的最大页面数
		long maxIndex = problemCount / 5;
		long tmp = problemCount % 5;
		if (tmp != 0) {
			maxIndex += 1;
		}
		long problemMaxPage = maxIndex;
		if (problemPage >= problemMaxPage) {
			problemPage = (int) problemMaxPage;
		}
		List<Problem> problemList = problemService.getProblemList(5,
				(problemPage - 1) * 5);

		request.put("problemList", problemList);
		request.put("problemCount", problemCount);

		long values[] = getIndexs(problemCount, 5);
		request.put("beginIndex", values[0]);
		request.put("endIndex", values[1]);
		return Status.SUCCESS;
	}

	public long[] getIndexs(long count, long length) {
		long[] indexs = new long[2];

		// 获取可以得到的最大页面数
		long maxIndex = count / length;
		long tmp = count % length;

		if (tmp != 0) {
			maxIndex += 1;
		}

		if (maxIndex < length) {
			// 如果最大的页面数小于要展示的出来的分页，那么开始为1，结束为最大页面数
			indexs[0] = 1;
			indexs[1] = maxIndex;
		} else {
			// 设置开始的数字
			if ((maxIndex - getProblemPage()) < length) {
				indexs[0] = maxIndex - length + 1;
			} else {
				indexs[0] = getProblemPage();
			}

			// 设置结束的数字
			if ((maxIndex - getProblemPage()) < length) {
				indexs[1] = maxIndex;
			} else {
				indexs[1] = getProblemPage() + length - 1;
			}
		}
		return indexs;
	}

}
