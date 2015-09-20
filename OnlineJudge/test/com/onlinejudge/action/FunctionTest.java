package com.onlinejudge.action;

/**
 * @author ��Ц��
 *
 * @time 2015��9��20��
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
