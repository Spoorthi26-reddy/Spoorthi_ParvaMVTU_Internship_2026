// ===============================
// SEARCH PRODUCTS
// ===============================

function searchProducts() {

    let input =
        document.getElementById("searchInput")
                .value
                .toLowerCase();

    let cards =
        document.querySelectorAll(".product-card");

    cards.forEach(card => {

        let title =
            card.querySelector(".product-title")
                .innerText
                .toLowerCase();

        if(title.includes(input)){
            card.style.display = "block";
        }else{
            card.style.display = "none";
        }

    });
}



// ===============================
// CATEGORY FILTER
// ===============================

function filterCategory(category){

    let cards =
        document.querySelectorAll(".product-card");

    cards.forEach(card => {

        let cardCategory =
            card.getAttribute("data-category");

        if(category === "all"){

            card.style.display = "block";

        }else if(cardCategory === category){

            card.style.display = "block";

        }else{

            card.style.display = "none";
        }

    });

}



// ===============================
// ADD TO CART BUTTON
// ===============================

function addToCart(productName){

    alert(productName + " added to cart!");

}