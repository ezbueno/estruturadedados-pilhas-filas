package pilha;

public class No {
	
	private int dado;
	private No refNo = null;

	public No() {
	}

	public No(int dado) {
		this.dado = dado;
	}

	public int getDado() {
		return this.dado;
	}

	public void setDado(int dado) {
		this.dado = dado;
	}

	public No getRefNo() {
		return this.refNo;
	}

	public void setRefNo(No refNo) {
		this.refNo = refNo;
	}

	@Override
	public String toString() {
		return "No [dado=" + dado + "]";
	}
}
