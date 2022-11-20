package trinh.vo.van.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import trinh.vo.van.constant.ResponseMessageConstant;
import trinh.vo.van.model.dto.request.user.SortByUser;
import trinh.vo.van.model.dto.response.user.UserResponses;
import trinh.vo.van.model.entity.user.User;
import trinh.vo.van.model.filter.RoleEnums;
import trinh.vo.van.model.filter.UserFilter;
import trinh.vo.van.repository.UserRepository;
import trinh.vo.van.service.user.UserService;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @Operation(description = "Get User")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = ResponseMessageConstant.RETRIEVED_SUCCESSFULLY),
            @ApiResponse(responseCode = "401", description = ResponseMessageConstant.NOT_ENOUGH_PRIVILEGE, content = @Content(schema = @Schema(hidden = true)))
    })
    @GetMapping("/api/user")
    public ResponseEntity<List<User>> getUser(
            @RequestParam(required = false,defaultValue = "") String userNameOrEmail ) {
            String searchValue  = "%" + userNameOrEmail + "%";
        return ResponseEntity.ok(userRepository.findByUsernameLikeAndEmailLike(searchValue, searchValue));
    }

    @Operation(description = "Get User list")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = ResponseMessageConstant.RETRIEVED_SUCCESSFULLY),
            @ApiResponse(responseCode = "401", description = ResponseMessageConstant.NOT_ENOUGH_PRIVILEGE, content = @Content(schema = @Schema(hidden = true)))
    })
    @GetMapping("/api/users")
    public ResponseEntity<List<UserResponses>> getUsers(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "REQUEST_DATETIME") SortByUser sortBy,
            @RequestParam(required = false, defaultValue = "DESC") Sort.Direction orderBy,
            @RequestParam(required = false) RoleEnums role,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromCreateDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date toCreateDate
    ) {

        //create user filter
        UserFilter userFilter = UserFilter.builder()
                .page(page)
                .size(size)
                .sortByUser(sortBy)
                .orderBy(orderBy)
                .role(role)
                .fromRequestDate(fromCreateDate)
                .toRequestDate(toCreateDate)
                .build();

        return ResponseEntity.ok(userService.getUsers(userFilter));
    }
}