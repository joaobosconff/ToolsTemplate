package jb.estudo.ferramentas.services;

import jb.estudo.ferramentas.dtos.CreateUserDTO;
import jb.estudo.ferramentas.interfaces.RoleService;
import jb.estudo.ferramentas.mappers.UserMapper;
import jb.estudo.ferramentas.models.User;
import jb.estudo.ferramentas.repository.UserRepository;
import jb.estudo.ferramentas.stub.CreateUserDTOStub;
import jb.estudo.ferramentas.stub.RoleStub;
import jb.estudo.ferramentas.stub.UserDTOStub;
import jb.estudo.ferramentas.stub.UserStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;

class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private RoleService roleService;
    @Mock
    private UserMapper userMapper;
    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;


    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    @DisplayName("Teste de Insert de Usuário na base")
    public void testInsertUser(){
        CreateUserDTO createUserDTO = CreateUserDTOStub.getStub();
        User user = UserStub.getStub();

        Mockito.when(userRepository.existsUserByLogin(createUserDTO.getLogin())).thenReturn(Boolean.FALSE);
        Mockito.when(userMapper.toEntity(createUserDTO)).thenReturn(user);
        Mockito.when(roleService.getRoleById(1)).thenReturn(RoleStub.getStub());
        Mockito.when(passwordEncoder.encode(user.getPassword())).thenReturn("123Cripted");

        user.setId(1);

        Mockito.when(userRepository.save(user)).thenReturn(user);
        Mockito.when(userMapper.toDTO(user)).thenReturn(UserDTOStub.getStub());

        var actual = userService.createUser(createUserDTO);

        assertNotNull(actual);
        assertEquals(createUserDTO.getName(),actual.getName());

        Mockito.verify(userRepository, times(1)).existsUserByLogin(anyString());




    }

}