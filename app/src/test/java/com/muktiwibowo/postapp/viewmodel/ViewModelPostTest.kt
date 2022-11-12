package com.muktiwibowo.postapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.muktiwibowo.postapp.repository.RepositoryPost
import junit.framework.TestCase
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


/**
 * Created by Mukti Wibowo on 12 November 2022
 * email: muktiwbowo@gmail.com
 */
@ExperimentalCoroutinesApi
@DelicateCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ViewModelPostTest: TestCase(){
    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()
    @Mock
    private lateinit var repositoryPost: RepositoryPost
    private lateinit var viewModelPost: ViewModelPost

    @Before
    public override fun setUp() {
        super.setUp()
        Dispatchers.setMain(Dispatchers.Unconfined)
        viewModelPost = ViewModelPost(repositoryPost)
    }

    @Test
    fun `testGetUser called once`() = runTest {
        viewModelPost.getPosts()
        verify(repositoryPost, times(1)).getUsers()
    }

    @Test
    fun `testGetPost called once`() = runTest {
        viewModelPost.getPosts()
        verify(repositoryPost, times(1)).getPosts()
    }

    @After
    public override fun tearDown() {
        super.tearDown()
        Dispatchers.resetMain()
    }
}