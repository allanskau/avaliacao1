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
        return new Complexo(((c.real*real + c.img*img) / (real*real + img*img)), // parte real
                            (real*c.img - c.real*img) / (real*real + img*img) ); // parte imaginaria
    }
    
    // implementar sqrt()
    public Complexo[] sqrt(Complexo c) {
        // completar implementação
        Complexo[] raizes = new Complexo[2];
        
        double r = Math.sqrt((c.real*c.real) + (c.img*c.img));
        double rho = Math.sqrt(r);
        double psi1;
        double psi2;
        double gama=0;
        if(c.real > 0){
            gama = Math.atan(c.img / c.real);
        }else if(c.real < 0){
            gama = Math.atan((c.img / c.real) + Math.PI);
        }else if((c.real == 0) && (c.img == 0)){
            gama = 0;
        }else if((c.real == 0) && (c.img > 0)){
            gama = Math.PI / 2;
        }else if((c.real == 0) && (c.img < 0)){
            gama = (3 * Math.PI) / 2;
        }
        psi1 = gama / 2;
        psi2 = (gama / 2) + Math.PI;
        
        raizes[0] = new Complexo(rho*(Math.acos(psi1)), rho*(Math.asin(psi1)));
        raizes[1] = new Complexo(rho*(Math.acos(psi2)), rho*(Math.asin(psi2)));
        
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
