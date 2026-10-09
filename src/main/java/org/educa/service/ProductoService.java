package org.educa.service;

import generated.Producto;
import jakarta.xml.bind.JAXBException;
import org.educa.dao.ProductoDAO;
import org.educa.entity.ProductoEntity;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ProductoService {

    public List<ProductoEntity> readFile(String fileXml) throws JAXBException {

        ProductoDAO productoDAO = new ProductoDAO();

        List<Producto> productos = productoDAO.getProductos(fileXml);

        List<ProductoEntity> listaProductos = new ArrayList<>();

        for (Producto producto : productos) {

            ProductoEntity productoEntity = new ProductoEntity();

<<<<<<< HEAD

            productoEntity.setProducto(producto);



            BigDecimal descuento = producto.getPrecio()
                    .multiply(producto.getDescuento());

            descuento = descuento.divide(BigDecimal.valueOf(100));



            BigDecimal precioFinal = producto.getPrecio()
                    .subtract(descuento);


            precioFinal = precioFinal.setScale(2, RoundingMode.HALF_UP);

=======
            productoEntity.setProducto(producto);

            BigDecimal precioFinal = producto.getPrecio()
                    .subtract(
                            producto.getPrecio()
                                    .multiply(producto.getDescuento())
                                    .divide(BigDecimal.valueOf(100))
                    )
                    .setScale(2, RoundingMode.HALF_UP);
>>>>>>> 8afa177 (Update3-Ejercicio2)


            BigDecimal costeAlmacenaje = producto.getCostes().getCostesAlmacenaje();

            BigDecimal costeEnvio = producto.getCostes().getCostesEnvio();

            BigDecimal coste = costeAlmacenaje.add(costeEnvio);

            coste = coste.setScale(2, RoundingMode.HALF_UP);


<<<<<<< HEAD

=======
>>>>>>> 8afa177 (Update3-Ejercicio2)
            BigDecimal beneficio = precioFinal.subtract(coste);

            beneficio = beneficio.setScale(2, RoundingMode.HALF_UP);

<<<<<<< HEAD


=======
>>>>>>> 8afa177 (Update3-Ejercicio2)
            productoEntity.setPrecioFinal(precioFinal);
            productoEntity.setCost(coste);
            productoEntity.setProfit(beneficio);



            listaProductos.add(productoEntity);
        }

        return listaProductos;
    }

    public void exportSummary(String path, String fileXml)
            throws JAXBException, IOException {


    }

    public void exportExcel(String path, String fileXml)
            throws JAXBException, IOException, ParseException {


<<<<<<< HEAD
    }
}
=======


    }
}

>>>>>>> 8afa177 (Update3-Ejercicio2)
