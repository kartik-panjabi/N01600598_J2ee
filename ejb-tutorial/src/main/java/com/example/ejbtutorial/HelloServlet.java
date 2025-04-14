    package com.example.ejbtutorial;

    import com.example.ejb.CalculatorBean;

    import jakarta.ejb.EJB;
    import jakarta.servlet.ServletException;
    import jakarta.servlet.annotation.WebServlet;
    import jakarta.servlet.http.*;

    import java.io.IOException;
    import java.io.PrintWriter;

    @WebServlet("/hello")
    public class HelloServlet extends HttpServlet {

        @EJB
        private CalculatorBean calculatorBean;
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            response.setContentType("text/plain");

            int a = 10, b = 5;

            int sum = calculatorBean.add(a, b);
            int difference = calculatorBean.subtract(a, b);
            int product = calculatorBean.multiply(a, b);
            int quotient = calculatorBean.divide(a, b);

            PrintWriter out = response.getWriter();
            out.println(a + " + " + b + " = " + sum);
            out.println(a + " - " + b + " = " + difference);
            out.println(a + " * " + b + " = " + product);
            out.println(a + " / " + b + " = " + quotient);
        }

    }
