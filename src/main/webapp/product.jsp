<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Stock Management</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 p-6">

<div class="max-w-3xl mx-auto bg-white p-6 rounded-lg shadow-lg">
    <h1 class="text-3xl font-bold mb-6 text-center text-gray-700">Stock Management</h1>

    <!-- Product Form -->
    <form id="productForm" class="space-y-4">
        <input type="hidden" id="productId">

        <div>
            <label for="productName" class="block font-medium text-gray-700">Product Name</label>
            <input type="text" id="productName" placeholder="Enter product name" 
                class="w-full p-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-400">
        </div>

        <div>
            <label for="productDescription" class="block font-medium text-gray-700">Description</label>
            <textarea id="productDescription" placeholder="Enter description"
                class="w-full p-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-400"></textarea>
        </div>

        <div class="grid grid-cols-2 gap-4">
            <div>
                <label for="productQuantity" class="block font-medium text-gray-700">Quantity</label>
                <input type="number" id="productQuantity" placeholder="Stock quantity"
                    class="w-full p-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-400">
            </div>

            <div>
                <label for="productPrice" class="block font-medium text-gray-700">Unit Price ($)</label>
                <input type="number" id="productPrice" placeholder="Enter price"
                    class="w-full p-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-400">
            </div>
        </div>

        <div>
            <label for="productCategory" class="block font-medium text-gray-700">Category</label>
            <select id="productCategory"
                class="w-full p-3 border border-gray-300 rounded-lg bg-white focus:ring-2 focus:ring-blue-400">
                <option value="">Select The Product</option>
                <option value="electronic devices">Electronic Devices</option>
                <option value="Fashion">Fashion</option>
                <option value="Toys">Toys</option>
                <option value="Furniture">Furniture</option>
                <option value="Automotive">Automotive</option>
            </select>
        </div>

        <button type="submit"
            class="w-full bg-black text-white p-3 rounded-lg font-semibold hover:bg-blue-600 transition duration-300">
            Save 
        </button>
    </form>
</div>

<!-- Product List -->
<div class="max-w-3xl mx-auto mt-8">
    <h2 class="text-2xl font-semibold mb-4 text-gray-700">Product List</h2>
    <ul id="productList" class="bg-white p-4 rounded-lg shadow-lg space-y-2"></ul>
</div>

</body>
</html>
