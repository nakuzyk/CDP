import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calculate extends HttpServlet {
    private double n1 = 0;
    private double n2 = 0;
    private String type = "";
    double result = 0;

    /**
     * Calculate Number 1 with Number 2!
     *
     * @param request Get numbers from html
     * @param response Post numbers to html
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response){
        try {
            n1 = Double.parseDouble(request.getParameter("n1"));
            n2 = Double.parseDouble(request.getParameter("n2"));
            type = request.getParameter("type");


            switch (type) {
                case "add":
                    result = n1 + n2;
                    break;
                case "sub":
                    result = n1 - n2;
                    break;
                case "mul":
                    result = n1 * n2;
                    break;
                case "div":
                    result = n1 / n2;
                    break;
            }

            response.sendRedirect("index.html?result=" + result);
        }

        catch(Exception e){
            try{
                response.sendRedirect("index.html?result=" + "Fail");
            }
            catch (IOException ex){
            }
        }
    }
}
