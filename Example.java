import ilog.concert.*;
import ilog.cplex.*;

public class Example { 
    public static void main(String[] args) { 
        try { 
            IloCplex  cplex =  new  IloCplex(); 
            int[]    lb =  {0, -Integer.MAX_VALUE, -Integer.MAX_VALUE}; // Bornes inférieur x1, x2 et pour x3 -inf
            int[]    ub =  {40, 100, Integer.MAX_VALUE}; // Borne supérieur x1, x2, x3
            IloIntVar[] x  = cplex.intVarArray(3, lb,  ub); 
            int[]  objvals =  {1, 2, 3}; 
            cplex.addMaximize(cplex.scalProd(x, objvals)); 
            cplex.addLe(cplex.sum(cplex.prod(-1.0, x[0]), 
                                  cplex.prod( 1.0, x[1]), 
                                  cplex.prod( 1.0, x[2])), 20.0); 
            cplex.addLe(cplex.sum(cplex.prod( 1.0, x[0]), 
                                  cplex.prod(-3.0, x[1]), 
                                  cplex.prod( 1.0, x[2])), 30.0); 
            if (cplex.solve()) { 
                cplex.output().println("Solution status =  "  +  cplex.getStatus()); 
                cplex.output().println("Solution value  = "  +  cplex.getObjValue()); 
                double[] val  =  cplex.getValues(x); 
                int ncols =  cplex.getNcols(); 
                for (int j  =  0;  j  <  ncols; ++j) {
                    cplex.output().println("Column: "  +  j  +  "  Value =  "  +  val[j]); 
                }
            }
        cplex.end();
        }
        catch (IloException e)  { 
            System.err.println("Concert exception '" + e + "' caught"); 
        }
    }
}