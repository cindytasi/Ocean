package manufactur.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import manufactur.dao.ManufactursDAO;
import manufactur.dao.ManufactursDAOimpl;
import manufactur.service.ManufacturServiceimpl;
import manufactur.service.ManufacturService;
import manufactur.vo.ProductLink;

@WebServlet("/TimestampServlet")
public class TimestampServlet extends HttpServlet {

    private ManufactursDAO dao;
    private ManufacturService manufacturService;

    @Override
    public void init() throws ServletException {
        super.init();
        manufacturService = new ManufacturServiceimpl();
        dao = new ManufactursDAOimpl();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        PrintWriter out = res.getWriter();

        List<ProductLink> timestampList = manufacturService.selectStatusLinkTimestamp();
        												

        Gson gson = new Gson();
        String json = gson.toJson(timestampList);

        out.print(json);
        out.flush();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
}
