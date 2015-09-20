package com.onlinejudge.action;

/**
 * @author 赵笑天
 *
 * @time 2015年9月20日
 * 
 */
public class FunctionTest {
	private long problemPage;

	public FunctionTest(long problemPage) {
		this.setProblemPage(problemPage);
	}

	public long getProblemPage() {
		return problemPage;
	}

	public void setProblemPage(long problemPage) {
		this.problemPage = problemPage;
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
