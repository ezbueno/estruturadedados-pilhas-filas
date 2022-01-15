package pilha;

import static java.util.Objects.isNull;

import java.util.Objects;

public class Pilha {
	private No refNoEntradaPilha;
	
	public Pilha() {
		this.refNoEntradaPilha = null;
	}
	
	public void push(No novoNo) {
		No refAuxiliar = this.refNoEntradaPilha;
		this.refNoEntradaPilha = novoNo;
		this.refNoEntradaPilha.setRefNo(refAuxiliar);
	}
	
	public No pop() {
		if (!this.isEmpty()) {
			No noPopped = this.refNoEntradaPilha;
			this.refNoEntradaPilha = this.refNoEntradaPilha.getRefNo();
			return noPopped;
		}
		return null;
	}
	
	public No top() {
		return this.refNoEntradaPilha;
	}
	
	public boolean isEmpty() {
		return isNull(this.refNoEntradaPilha);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("---------------\n");
		sb.append("     Pilha     \n");
		sb.append("---------------\n");
		
		No noAuxiliar = this.refNoEntradaPilha;
		
		while (true) {
			if (!Objects.isNull(noAuxiliar)) {
				sb.append("[No{dado=" + noAuxiliar.getDado() + "}]\n");
				noAuxiliar = noAuxiliar.getRefNo();
			} else {
				break;
			}
		}
		sb.append("===============\n");
		return sb.toString();
	}
}
