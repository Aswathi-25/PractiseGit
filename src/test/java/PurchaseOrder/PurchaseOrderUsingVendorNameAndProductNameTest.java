package PurchaseOrder;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import ObjectRepo.CreateNewProductPage;
import ObjectRepo.CreateNewPurchaseOrderPage;
import ObjectRepo.CreateNewVendorPage;
import ObjectRepo.HomePage;
import ObjectRepo.ProductInfoPage;
import ObjectRepo.ProductsPage;
import ObjectRepo.PurchaseOrderInfoPage;
import ObjectRepo.PurchaseOrderPage;
import ObjectRepo.VendorInfoPage;
import ObjectRepo.VendorsPage;

public class PurchaseOrderUsingVendorNameAndProductNameTest extends BaseClass {

	@Test(retryAnalyzer = Generic_Utilities.RetryImpClass.class)
	public void PurchaseOrderUsingVendorNameAndProductNameTest() throws EncryptedDocumentException, IOException {

		// vendor details
		String VendorName = eutls.readDataFromExcel("Vendors", 0, 1) + jutls.getRandomNo();
		String ven_email = eutls.readDataFromExcel("Vendors", 1, 1);
		String ven_phone = eutls.readDataFromExcel("Vendors", 2, 1);

		// product details
		String ProductName = eutls.readDataFromExcel("Products", 0, 1) + jutls.getRandomNo();

		// Purchase order details
		// Read data from Excel file
		String SubName = eutls.readDataFromExcel("Purchase_Order", 0, 1) + jutls.getRandomNo();
		String bill_add = eutls.readDataFromExcel("Purchase_Order", 1, 1);
		String pur_qty = eutls.readDataFromExcel("Purchase_Order", 2, 1);

//-----------------------------------------------------------------------------------		

		// click on Vendor link
		HomePage hp = new HomePage(driver);
		hp.clickOnMoreLink();
		hp.clickOnVendorsLink();

		VendorsPage vp = new VendorsPage(driver);
		vp.clickOnVendorLookUpImg();

		CreateNewVendorPage cnvp = new CreateNewVendorPage(driver);
		cnvp.createVendor(VendorName, ven_email, ven_phone);

		VendorInfoPage vip = new VendorInfoPage(driver);
		vip.validatingVendor(driver, VendorName);
		// --------------------------------------------------------------
		hp.clickOnProductsLink();
		// products link clicking
		ProductsPage pp = new ProductsPage(driver);
		pp.clickOnProductsLookUp();

		// clicking on lookup image

		// Name textfield
		CreateNewProductPage cnpg = new CreateNewProductPage(driver);
		cnpg.createProduct(ProductName);

		ProductInfoPage pip = new ProductInfoPage(driver);
		pip.validatingProduct(ProductName);

//----------------------------------------------------------------------------

		// click on Purchase Order link

		hp.clickOnMoreLink();
		hp.clickOnPurchaseOrderLink();

		PurchaseOrderPage pop = new PurchaseOrderPage(driver);
		pop.clickOnPurchaseOrder();

		CreateNewPurchaseOrderPage cnpop = new CreateNewPurchaseOrderPage(driver);
		cnpop.createPurchaseOrder(driver, SubName, VendorName, ProductName, bill_add, pur_qty);

		PurchaseOrderInfoPage poip = new PurchaseOrderInfoPage(driver);
		poip.validatingPurchaseOrder(driver, SubName);

	}

}
