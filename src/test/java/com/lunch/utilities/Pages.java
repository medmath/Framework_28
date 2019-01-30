package com.lunch.utilities;

import com.lunch.pages.*;

public class Pages {
    private LoginPage loginPage;
    private LunchHomePage lunchHomePage;
    private AlertsPage alertsPage;
    private ControlAccountsPage controlAccountsPage;
    private EmployeePaymentsPage employeePaymentsPage;
    private OrdersByVendorPage ordersByVendorPage;
    private NewOrderPage newOrderPage;
    private PreviousOrdersPage previousOrdersPage;
    private ProductCategoriesPage productCategoriesPage;
    private ProductsPage productsPage;
    private TodaysOrdersPage todaysOrdersPage;
    private YourLunchAccountPage yourLunchAccountPage;




    public LoginPage login(){
        if(loginPage == null){
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public LunchHomePage lunchHomePage(){
        if(lunchHomePage == null){
            lunchHomePage = new LunchHomePage();
        }
        return lunchHomePage;
    }

    public AlertsPage getAlertsPage(){
        if(alertsPage == null){
            alertsPage = new AlertsPage();
        }
        return alertsPage;
    }


    public ControlAccountsPage getControlAccountsPage(){
        if(controlAccountsPage == null){
            controlAccountsPage = new ControlAccountsPage();
        }
        return controlAccountsPage;
    }


    public EmployeePaymentsPage getEmployeePaymentsPage(){
        if(employeePaymentsPage == null){
            employeePaymentsPage = new EmployeePaymentsPage();
        }
        return employeePaymentsPage;
    }


    public OrdersByVendorPage getOrdersByVendorPage (){
        if(ordersByVendorPage == null){
            ordersByVendorPage = new OrdersByVendorPage();
        }
        return ordersByVendorPage;
    }


    public NewOrderPage getNewOrderPage(){
        if(newOrderPage == null){
            newOrderPage = new NewOrderPage();
        }
        return newOrderPage;
    }


    public PreviousOrdersPage getPreviousOrdersPage(){
        if(previousOrdersPage == null){
            previousOrdersPage = new PreviousOrdersPage();
        }
        return previousOrdersPage;
    }


    public ProductCategoriesPage getProductCategoriesPage(){
        if(productCategoriesPage == null){
            productCategoriesPage = new ProductCategoriesPage();
        }
        return productCategoriesPage;
    }


    public ProductsPage getProductsPage(){
        if(productsPage == null){
            productsPage = new ProductsPage();
        }
        return productsPage;
    }


    public TodaysOrdersPage getTodaysOrdersPage(){
        if(todaysOrdersPage == null){
            todaysOrdersPage = new TodaysOrdersPage();
        }
        return todaysOrdersPage;
    }


    public YourLunchAccountPage getYourLunchAccountPage(){
        if(yourLunchAccountPage == null){
            yourLunchAccountPage = new YourLunchAccountPage();
        }
        return yourLunchAccountPage;
    }

}

