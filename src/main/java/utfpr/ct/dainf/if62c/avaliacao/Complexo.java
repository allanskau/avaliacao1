package utfpr.ct.dainf.if62c.avaliacao;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná
 * DAINF - Departamento Acadêmico de Informática
 * IF62C - Fundamentos de Programação 2
 * 
 * Primeira avaliação parcial 2014/2.
 * @author 
 */
public class Complexo {
    private double real;
    private double img;

    public Complexo() {
    }

    public Complexo(double real, double img) {
        // completar a implementação
        this.real = real;
        this.img = img;
    }
    

    // implementar getReal()
    public double getReal(){
        return real;
    }
    
    // implementar getImg()
    public double getImg(){
        return img;
    }

    public Complexo soma(Complexo c) {
        return new Complexo(real + c.real, img + c.img);
    }
    
    // implementar sub(Complexo)
    public Complexo sub(Complexo c){
        return new Complexo(real - c.real, img - c.img);
    }

    // implementar prod(double)
    public Complexo prod(double multiplicador){
        return new Complexo(real * multiplicador, img * multiplicador);
    }

    // implementar prod(Complexo)
    public Complexo prod(Complexo c){
        return new Complexo((real * c.real) - (img * c.img), (real * c.img) + (img * c.real));
    }
    
    // implementar div(Complexo)
    public Complexo div(Complexo c){
        return new Complexo( ((real*c.real + img*c.img) / ( c.real*c.real + c.img*c.img)), // parte real
                            ( (c.real*img - real*c.img) / (c.real*c.real + c.img*c.img) ) ); // parte imaginaria
    }
    
    // implementar sqrt()
    public Complexo[] sqrt() {
        // completar implementação
        Complexo[] raizes = new Complexo[2];
        
        double r = Math.sqrt((real*real) + (img*img));
        System.out.println("r = " + r);
        double rho = Math.sqrt(r);
        System.out.println("rho = " + rho);
        double psi1;
        double psi2;
        double gama = 0;
        if(real > 0){
            gama = Math.atan(img / real);
        }else if(real < 0){
            gama = (Math.atan(img / real) + Math.PI);
        }else if((real == 0) && (img == 0)){
            gama = 0;
        }else if((real == 0) && (img > 0)){
            gama = Math.PI / 2;
        }else if((real == 0) && (img < 0)){
            gama = (3 * Math.PI) / 2;
        }
        //System.out.println("gama = " + gama);
        psi1 = gama / 2;
        //System.out.println("psi1 = " + psi1);
        psi2 = (gama / 2) + Math.PI;
        //System.out.println("psi2 = " + psi2);
        
        raizes[0] = new Complexo(rho*(Math.cos(psi1)), rho*(Math.sin(psi1)));
        //System.out.println("raizes[0] = " + raizes[0]);
        raizes[1] = new Complexo(rho*(Math.cos(psi2)), rho*(Math.sin(psi2)));
        //System.out.println("raizes[1] = " + raizes[1]);
        
        // retornar o vetor contendo as raízes
        return raizes;
        //return null;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (int) (Double.doubleToLongBits(real)
            ^ (Double.doubleToLongBits(real) >>> 32));
        hash = 41 * hash + (int) (Double.doubleToLongBits(img)
            ^ (Double.doubleToLongBits(img) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        final Complexo c = (Complexo) obj;
        return obj != null && getClass() == obj.getClass()
            && real == c.real && img == c.img;
    }

    @Override
    public String toString() {
        return String.format("%+f%+fi", real, img);
    }
}
