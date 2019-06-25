import java.util.List;

public class CalculoPreco {
	
	  private static int IDADE_ADULTA = 18;
	    private static int IDADE_LIVRE_PERMITIDA = 3;
	    public static double DESCONTO_FAMILIA = 0.05;

	    public double calcularPreco(List<Passageiro> passageiros, int precoPassagemAdulto, int precoPassagemCrianca) {
	        int precoTotal = 0;
	        int countCrianca = 0;
	        int countAdulto = 0;
	        double result;
	        for (Passageiro passageiro : passageiros) {
	            if (passageiro.getIdade() > IDADE_ADULTA) {
	                precoTotal += precoPassagemAdulto;
	                countAdulto++;
	            } else if (passageiro.getIdade() > IDADE_LIVRE_PERMITIDA) {
	                precoTotal += precoPassagemCrianca;
	                countCrianca++;
	            }
	        }

	        if (countCrianca > 1 && countAdulto > 1) {
	            result = (1 - DESCONTO_FAMILIA) * precoTotal;
	        } else {
	            result = precoTotal;
	        }

	        return result;
	    }
}
