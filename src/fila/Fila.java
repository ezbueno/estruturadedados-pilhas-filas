package fila;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Fila<T> {

	private No<T> refNoEntradaFila;

	public Fila() {
		this.refNoEntradaFila = null;
	}

	public void enqueue(T object) {
		No<T> novoNo = new No<>(object);
		novoNo.setRefNo(this.refNoEntradaFila);
		this.refNoEntradaFila = novoNo;
	}

	public T first() {
		if (!this.isEmpty()) {
			No<T> primeiroNo = this.refNoEntradaFila;

			while (true) {
				if (nonNull(primeiroNo.getRefNo())) {
					primeiroNo = primeiroNo.getRefNo();
				} else {
					break;
				}
			}
			return primeiroNo.getObject();
		}
		return null;
	}

	public T dequeue() {
		if (!this.isEmpty()) {
			No<T> primeiroNo = this.refNoEntradaFila;
			No<T> noAuxiliar = this.refNoEntradaFila;

			while (true) {
				if (nonNull(primeiroNo.getRefNo())) {
					noAuxiliar = primeiroNo;
					primeiroNo = primeiroNo.getRefNo();
				} else {
					noAuxiliar.setRefNo(null);
					break;
				}
			}
			return primeiroNo.getObject();
		}
		return null;
	}

	public boolean isEmpty() {
		return isNull(this.refNoEntradaFila);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		No<T> noAuxiliar = this.refNoEntradaFila;

		if (nonNull(this.refNoEntradaFila)) {
			while (true) {
				sb.append("[No{objeto=" + noAuxiliar.getObject() + "}]--->");

				if (nonNull(noAuxiliar.getRefNo())) {
					noAuxiliar = noAuxiliar.getRefNo();
				} else {
					sb.append("null");
					break;
				}
			}
		} else {
			sb.append("null");
		}

		return sb.toString();
	}
}
