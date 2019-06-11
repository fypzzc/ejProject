package com.ejserver.apps.ej.web.controller;

import javax.annotation.Resource;

import com.ejserver.apps.ej.bean.Product;
import com.ejserver.apps.ej.dto.ProductAndOrderLine;
import com.ejserver.apps.ej.service.IOrderLineService;
import com.ejserver.apps.ej.service.IProductService;
import com.ejserver.apps.ej.utils.ActionResult;
import com.ejserver.apps.ej.utils.ActionResultUtil;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * @author 张连硕
 * 2019/06/10 afternoon
 */
@RestController
@RequestMapping("product")
public class ProductController {
    @Resource
    private IProductService productService;
<<<<<<< HEAD
    @Resource
    private IOrderLineService orderLineService;
=======

>>>>>>> 1ac095a2a8301d504cceb1f661a34366a372bfd8

    @ApiOperation("查询所有")
    @GetMapping("/findAll")
    public ActionResult findAll() {
        return ActionResultUtil.success("success", productService.findAll());
    }

    @ApiOperation("通过ID查询数据")
    @GetMapping("/findById")
    public ActionResult findById(Long id) {
        return ActionResultUtil.success("success", productService.findById(id));
    }

    @ApiOperation("通过ID删除数据")
    @PostMapping("/deleteById")
    public ActionResult deleteById(Long id) {
        try {
            productService.deleteById(id);
            return ActionResultUtil.success("success");
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResultUtil.error(e.getMessage());
        }

    }

    @ApiOperation("插入数据")
    @PostMapping("/insert")
    public ActionResult insert(Product product) {
        try {
            productService.insert(product);
            return ActionResultUtil.success("success");
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResultUtil.error(e.getMessage());
        }
    }

    @ApiOperation("通过ID修改数据")
    @PostMapping("/saveOrUpdate")
    public ActionResult saveOrUpdate(Product product) {

        try {
            productService.saveOrUpdate(product);
            return ActionResultUtil.success("success");
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResultUtil.error(e.getMessage());
        }
    }

    @ApiOperation("通过商品Id查找商品和列表项")
    @PostMapping("/findProductAndOrderLineByProductId")
    public ActionResult findProductAndOrderLineByProductId(Long id) {
        Product product = productService.findById(id);
        if (product == null) {
            return ActionResultUtil.error("id不存在");
        }
        ProductAndOrderLine productAndOrderLine = new ProductAndOrderLine();
        productAndOrderLine.setProduct(product);
        productAndOrderLine.setOrderLines(orderLineService.findByProductId(id));
        return ActionResultUtil.success("成功", productAndOrderLine);
    }

}