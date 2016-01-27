package com.onlinejudge.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.onlinejudge.constant.Status;
import com.onlinejudge.domain.ProblemListItem;
import com.onlinejudge.domain.database.Notice;
import com.onlinejudge.domain.database.Problem;
import com.onlinejudge.domain.database.SubmitTime;
import com.onlinejudge.service.NoticeService;
import com.onlinejudge.service.ProblemService;
import com.onlinejudge.service.SubmitTimesService;
import com.onlinejudge.tool.ConfigsOperator;

/**
 * @author ��Ц��
 *
 * @time 2015��9��16��
 * 
 */

@Component("problemListAction")
public class ProblemListAction implements RequestAware,ServletContextAware,SessionAware {
	private ProblemService problemService;
	private Map<String, Object> request;
	private int problemPage;
	private ServletContext context;
	private Map<String,Object> session;


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

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

	/*public String getMainPage() {
		long problemCount = problemService.getProblemCount();
		// ��ȡ���Եõ������ҳ����
		long maxIndex = problemCount / 5;
		long tmp = problemCount % 5;
		if (tmp != 0) {
			maxIndex += 1;
		}
		long problemMaxPage = maxIndex;
		if (problemPage >= problemMaxPage) {
			problemPage = (int) problemMaxPage;
		}
		List<ProblemListItem> problemListItems = problemService.getProblemList(5,
				(problemPage - 1) * 5,session);

		request.put("problemListItems", problemListItems);
		request.put("problemCount", problemCount);

		long values[] = getIndexs(problemCount, 5);
		request.put("beginIndex", values[0]);
		request.put("endIndex", values[1]);
		return Status.SUCCESS;
	}*/
	
	public String getProblemList() throws  Exception{
		ConfigsOperator co = new ConfigsOperator();
		int currentRound = Integer.parseInt(co.getProperties("currentRound"));
		
		List <ProblemListItem> problemListItems = problemService.getProblemListByRound(currentRound,session);
		request.put("problemListItems", problemListItems);
		
		
		return Status.SUCCESS;
	}

	public long[] getIndexs(long count, long length) {
		long[] indexs = new long[2];

		// ��ȡ���Եõ������ҳ����
		long maxIndex = count / length;
		long tmp = count % length;

		if (tmp != 0) {
			maxIndex += 1;
		}

		if (maxIndex < length) {
			// �������ҳ����С��Ҫչʾ�ĳ����ķ�ҳ����ô��ʼΪ1������Ϊ���ҳ����
			indexs[0] = 1;
			indexs[1] = maxIndex;
		} else {
			// ���ÿ�ʼ������
			if ((maxIndex - getProblemPage()) < length) {
				indexs[0] = maxIndex - length + 1;
			} else {
				indexs[0] = getProblemPage();
			}

			// ���ý���������
			if ((maxIndex - getProblemPage()) < length) {
				indexs[1] = maxIndex;
			} else {
				indexs[1] = getProblemPage() + length - 1;
			}
		}
		return indexs;
	}
	

}
