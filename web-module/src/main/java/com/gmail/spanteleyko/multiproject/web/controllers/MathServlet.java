package com.gmail.spanteleyko.multiproject.web.controllers;

import com.gmail.spanteleyko.multiproject.web.constants.MediaTypeConstants;
import com.gmail.spanteleyko.multiproject.web.constants.PropertyConstants;
import com.gmail.spanteleyko.multiproject.web.repositories.PropertyRepository;
import com.gmail.spanteleyko.multiproject.web.repositories.impl.PropertyRepositoryImpl;
import com.gmail.spanteleyko.multiproject.web.services.FileService;
import com.gmail.spanteleyko.multiproject.web.services.impl.FileServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MathServlet", value = "/math")
public class MathServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(MathServlet.class);
    private FileService fileService;
    private PropertyRepository propertyRepository;

    public MathServlet() {
        fileService = FileServiceImpl.getInstance();
        propertyRepository = PropertyRepositoryImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = propertyRepository.get(PropertyConstants.FILE_NAME);

        response.setContentType(MediaTypeConstants.TEXT_HTML);
        try {
            int total = fileService.calculateTotal(fileName);

            try (PrintWriter writer = response.getWriter()) {
                String html = """
                        <html>
                            <body>
                                <p>total =  %d</p>
                            </body>
                        </html>
                        """.formatted(total);
                writer.println(html);
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

    }
}
