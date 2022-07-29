<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>vote1Page</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://www.markuptag.com/bootstrap/5/css/bootstrap.min.css">


    <style>
        header {
            position: fixed;
            top: 0;
            left: 0;
            right: 0;

            height: 100px;
            background-color: white;

        }

        main {
            background-color: hsl(228, 26%, 96%);
            min-height: 1000px;
            margin-top: 100px;

        }

        footer {
            position: absolute;
            background-color: white;
            bottom: 0;
            width: 100%;
            height: 60px;

        }
    </style>
</head>

<body>

    <header class="fixed-top" style="border-bottom: 1px solid hsl(0, 0%, 56%);">
        <img src="/resources/img/Logo.png" style="height: 100px; border-bottom: 1px solid hsl(0, 0%, 56%);">

    </header>

    <main>

        <div class="container">
            <div class="row">
                <div class="col-md-8 offset-md-2">
                    <div class="login-form bg-white mt-4 p-4 rounded">
                        <form action="" method="" class="row g-3">
                            <span style="font-size: 20px;"> 선거 이름~~~~~~~~~~~</span>
                            <hr class="mt-4">

                            <div class="container mb-3 rounded" style="background-color: hsl(228, 26%, 96%);
                            padding-top: 10px; padding-bottom: 30px;">
                                <span class="px-3" id="candidate" style="padding-top: 10px; font-size: 30px;">
                                    후보자 목록</span>



                                <div class="my-3" style="padding-top: 10px">
                                    <div class="card background-color white">
                                        <div class="row card-body">

                                            <div class="col-sm my-3" style="text-align: start">
                                                <img src="/resources/img/zzang.png" width="300" height="400">
                                            </div>

                                            <div class="col-sm my-3">

                                                <h3 class="candidate"><b>기호 1번 장재영</b></h3>
                                                <p>
                                                    <br>
                                                    후보자 설명~~~~~~~~~~~~
                                                    후보자 설명~~~~~~~~~~~~
                                                    후보자 설명~~~~~~~~~~~~
                                                    후보자 설명~~~~~~~~~~~~

                                                    <br>
                                                </p>
                                            </div>

                                        </div>
                                    </div>
                                </div>



                            </div>



                            <div class="container" style="text-align: center; padding-top: 10px;">
                                <div class="form-check form-check-inline ">
                                    <input class="form-check-input" type="radio" name="inlineRadioOptions"
                                        id="inlineRadio1" value="option1">
                                    <p class="agree">찬성</p>
                                </div>
                                <div class="form-check form-check-inline" style="padding-left: 150px;">
                                    <input class="form-check-input" type="radio" name="inlineRadioOptions"
                                        id="inlineRadio2" value="option2">
                                    <p class="disagree">반대</p>
                                </div>
                                <div class="form-check form-check-inline" style="padding-left: 150px;">
                                    <input class="form-check-input" type="radio" name="inlineRadioOptions"
                                        id="inlineRadio3" value="option3">
                                    <p class="giveup">기권</p>
                                </div>
                            </div>


                            <div class="d-grid gap-2 col-6 mx-auto">
                                <a href="#" class="btn btn-primary" tabindex="-1" role="button"
                                    aria-disabled="true" onclick="votecheck()">투표하기</a>
                            </div>

                    </div>

                    </form>

                </div>
            </div>
        </div>
        </div>


    </main>
<script>

function votecheck(){

    var result = confirm("투표하시겠습니까?")
    if(result == true){
        alert("투표가 완료되었습니다.")
    }
    else{
        alert("취소되었습니다.")
    }
}

</script>
    <div class="fixed-bottom">
        <footer>
            <div>
                <p style="text-align:center; color: hsl(0, 0%, 34%); padding: 1rem;">@2022 Team Coding Quokka All Rights
                    Reserved</p>
            </div>
        </footer>
    </div>
</body>