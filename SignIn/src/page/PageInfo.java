package page;

import java.io.Serializable;

/**
 * ��ҳ��
 * 
 * @author yejianyi
 *
 */
public class PageInfo implements Serializable {

	private static final long serialVersionUID = 1878154374135400744L;

	public static final String DEFAULT_PAGE_SIZE = "4";// Ĭ��ÿҳ��������¼
	public static final String DEFAULT_LIST_OFFSET = "0";// Ĭ�ϴӵڼ�����¼��ʼ

	private String firstResult = "0"; // ��ҳ�ӵڼ�����¼��ʼ

	private String maxResults; // һҳ����������¼

	private int pageNo = 0; // ��ǰҳ

	private transient String itemCount = "0"; // �ܼ�¼��

	public boolean isPage = true;

	public String getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(String firstResult) {
		this.firstResult = firstResult;
	}

	public String getItemCount() {
		return itemCount;
	}

	public void setItemCount(String itemCount) {
		this.itemCount = itemCount;
	}

	public String getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(String maxResults) {
		this.maxResults = maxResults;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}


}
