
public class Addition implements BinaryOp {

	@Override
	public int execute(int op1, int op2) {
		int result = op1 + op2;
		return result;
	}

}
