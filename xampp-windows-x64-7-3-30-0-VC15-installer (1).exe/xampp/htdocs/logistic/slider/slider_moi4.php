<?php 
    class shop
    {
        
        function __construct($name,$meta_description,$image){
                $this->name=$name;
                $this->meta_description=$meta_description;
                $this->image=$image;
            }
        }
        $datashop = array(
            array('Lorem ipsum dolor sit amet','$1330.00','NEWSCAR18.jpeg'),
            array('Lorem ipsum dolor sit amet','$8330.00','NEWSCAR19.jpeg'),
            array('Lorem ipsum dolor sit amet','$6330.00','NEWSCAR20.jpeg'),
            array('Lorem ipsum dolor sit amet','$7330.00','NEWSCAR21.jpeg'),
            array('Lorem ipsum dolor sit amet','$9330.00','NEWSCAR22.jpg'),

        );
    
        
        $shop = array();
        foreach($datashop as $key => $value){
            array_push($shop,new shop($value[0],$value[1],$value[2]));
        }
?>
<style>
    .moi4 .owl-nav [class*=owl-]:hover {
        color: #b68944;
        background-color: unset;
    }
    .moi4>.owl-nav>.owl-next{
        top: 50%;
        position: absolute;
        left: -3vw;
    }
    .moi4>.owl-nav>.owl-prev{
        top: 50%;
        position: absolute;
        right: -3vw;
    }
    .card-text {
        min-height: 70px;
    }
    .card_img{
        height: 33vw;
    }
    .product{
        width: 188px;
        padding-left: 8px;
        padding-right: 8px;

    }
    @media (min-width: 768px){
        .card_img{
            height: 10vw;
        }
        .card-text {
            min-height: 70px;
        }
        .moi4>.owl-nav>.owl-next{
            top: 50%;
            position: absolute;
            left: -5vw;
        }
        .moi4>.owl-nav>.owl-prev{
            top: 50%;
            position: absolute;
            right: -5vw;
        }
        .product{
            width: 20%;
            padding-left: 10px;
            padding-right: 10px;

        }
        .bg{
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
        }
        .button-add:hover{
            background-color: #D12442  !important;
            color: white;
            border-color: #D12442 !important;
        }
        .text-newsdetail{
            color:#505050;
        }
        .moi4 .owl-nav.disabled {
            display: block;
        }
    }
</style>




    <div class="px-0">
        <div class="moi4 owl-carousel owl-theme">
            <?php
                foreach ($shop as $key => $value) {
                    # code...
                
            ?>
                
                    <div class="card  ">
                        <div class="position-relative px-0">
                            <div class="card_img bg" style="background-image: url(public/demo/<?php echo $value->image; ?>);">
                                
                            </div>
                        </div>
                        <div class="card-body">
                            <h5 class="card-title text-newsdetail fs-6 "><?php echo $value->name ?></h5>
                            <p class="card-text fw-bold " ><?php echo $value->meta_description; ?></p>
                            <button type="button" class="btn btn-dark w-100 rounded-0 p-3 fw-bold button-add">ADD TO BAG</button>
                        </div>
                    </div>
                
            <?php } ?>
        </div>   
    </div>




<script src="owlcarousel/owl.carousel.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){

        $('.moi4').owlCarousel({
            center: false,
            loop:true,
            margin:16,
            nav:true,
            dots:false,
            autoplay:true,
            responsive:{
                0:{
                    items:2
                },
                600:{
                    items:2
                },
                900:{
                    items:5
                }
            }
        });
        $( ".owl-next").html('<i class="bi bi-arrow-left-short fs-1"></i>');
         $( ".owl-prev").html('<i class="bi bi-arrow-right-short fs-1"></i>');


    });
</script>